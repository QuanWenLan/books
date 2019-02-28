package com.dragon.book.service.impl;

import com.dragon.book.mapper.EbookInfoMapper;
import com.dragon.book.mapper.TEBookMapper;
import com.dragon.book.mapper.TTypeMapper;
import com.dragon.book.mapper.TUserBookMapper;
import com.dragon.book.model.*;
import com.dragon.book.service.ebookService.EbookFileService;
import com.dragon.book.config.FtpConfig;
import com.dragon.book.utils.FtpUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class EbookFileServiceImpl implements EbookFileService {

    @Autowired
    private FtpConfig ftpConfig;

    @Autowired
    private TEBookMapper teBookMapper;

    @Autowired
    private TTypeMapper tTypeMapper;

    @Autowired
    private EbookInfoMapper ebookInfoMapper;

    @Autowired
    private TUserBookMapper tUserBookMapper;

    /**
     * 获取ftp服务器的配置
     */
    @Override
    public FTPClient getFtpConfig() {
        FTPClient ftpClient = null;
        String ftpHost = ftpConfig.getFtpHost();
        Integer ftpPort = ftpConfig.getFtpPort();
        String ftpUserName = ftpConfig.getFtpUserName();
        String ftpPassWord = ftpConfig.getFtpPassWord();
        try {
            ftpClient = FtpUtils.getLocalFtpConnection(ftpHost, ftpUserName, ftpPassWord, ftpPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftpClient;
    }


    @Override
    public List<String> getDirectories(FTPClient ftpClient) {
        List<String> dirList = new ArrayList<>();
        try {
            FTPFile[] fileDirectory = ftpClient.listDirectories();
            String[] fileName = new String[fileDirectory.length];
            for (int i = 0; i < fileDirectory.length; i++) {
                fileName[i] = new String(fileDirectory[i].getName().getBytes(StandardCharsets.ISO_8859_1), "GBK");
                dirList.add(fileName[i]);
                System.out.println("目录：" + fileName[i]);
            }
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirList;
    }


    @Override
    public String getDownloadUrl(String ftpPath, String fileName) {
        String ftpHost = ftpConfig.getFtpHost();
        String ftpUserName = ftpConfig.getFtpUserName();
        String ftpPassWord = ftpConfig.getFtpPassWord();
        try {
            fileName = URLEncoder.encode(fileName, "GBK");
            ftpPath = URLEncoder.encode(ftpPath, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "ftp://" + ftpUserName + ":" + ftpPassWord + "@" + ftpHost + "/" + ftpPath + "/" + fileName + "";
        System.out.println("ftp服务器的文件的根路径：" + url);
        return url;
    }

    /**
     * @param ftpClient   ftp对象
     * @param inputStream 上传输入流
     * @param bookName    上传电子书名
     * @param ftpPath     ftp服务器的路径
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean uploadEbookFile(FTPClient ftpClient, InputStream inputStream, String ftpPath, String bookName) {
        return FtpUtils.upload(ftpClient, inputStream, "/" + ftpPath + "/", bookName);
    }

    @Override
    public boolean saveEbookFile(TEBook teBook) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        teBook.setScsj(df.format(date));
        TType tType = tTypeMapper.selectByPrimaryKey(teBook.getTypeId());
        String wjdz = tType.getLxmc();
        teBook.setWjdz(wjdz);
        int row = teBookMapper.insert(teBook);
        TUserBook tUserBook = new TUserBook();
        tUserBook.setIsbn(teBook.geteBookId());
        tUserBook.setUserId(10001);
        int row2 = tUserBookMapper.insert(tUserBook);
        return row > 0 && row2 > 0;
    }


    @Override
    public InputStream getFtpInputStream(FTPClient ftpClient, String fileName, String ftpPath) {
        return FtpUtils.getFileStream(ftpClient, fileName, ftpPath);
    }

    @Override
    public TType getTTypeByPk(int pk) {
        return tTypeMapper.selectByPrimaryKey(pk);
    }

    @Override
    public List<TType> getTypeList() {
        TTypeExample example = new TTypeExample();
        return tTypeMapper.selectByExample(example);
    }

    @Override
    public TEBook getSingleEbook(String ebookId) {
        return teBookMapper.selectByPrimaryKey(ebookId);
    }

    @Override
    public List<TEBookVo> getTEBookVoList(Map filter) {
        return ebookInfoMapper.queryTEBookVo(filter);
    }

    @Override
    public Integer getCount(Map filter) {
        return ebookInfoMapper.countTEBookVo(filter);
    }

    // 封装的单个或多个文件上传代码
    @Override
    public boolean ebookFileSingleOrMulUpload(MultipartFile[] ebookFile, TEBook teBook) {
        boolean result = false, flag = false;
        TType tType = getTTypeByPk(teBook.getTypeId());
        String typeName = tType.getLxmc();
//        String[] xmsArr = teBook.geteBookXm().split("；"); // 分割 书名
        String[] msArr = teBook.getMs().split("；");  // 分割 描述
        try {
            for (int i = 0; i < ebookFile.length; i++) {
                String ebookId = UUID.randomUUID().toString().replace("-", "");
                String fileName = ebookFile[i].getOriginalFilename();  // 上传到服务器的文件名

                InputStream inputStream = ebookFile[i].getInputStream();
                FTPClient ftp = getFtpConfig();
                result = uploadEbookFile(ftp, inputStream, "/" + typeName + "/", fileName);  // 上传到服务器

                if (result) {
                    teBook.seteBookId(ebookId);
//                    teBook.seteBookXm(xmsArr[i]);   // 存在数据库中的文件地址
                    teBook.seteBookXm(fileName);      // 存在数据库中的文件地址
                    teBook.setMs(msArr[i]);
                    flag = saveEbookFile(teBook);
                }
            }
        } catch (Exception e) {
            System.out.println("上传失败");
            e.printStackTrace();
        }
        if (result && flag) {
            return true;
        } else {
            return false;
        }
    }

    // 封装的文件下载代码
    @Override
    public boolean serviceDownload(InputStream inputStream, OutputStream outputStream) {
        boolean result;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 将输入流中的数据写入到输出流中
            result = FtpUtils.fileReadWrite(bufferedInputStream, bufferedOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }
}