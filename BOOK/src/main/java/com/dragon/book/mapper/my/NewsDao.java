package com.dragon.book.mapper.my;

import com.dragon.book.model.TBookNews;
import com.dragon.book.model.TBorrow;
import com.dragon.book.model.TStore;
import com.dragon.book.pojo.BookNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDao {

    /**
     * 获得个人消息总览
     *
     * @param userId
     * @return
     */
    public List<BookNews> findNews(@Param("userId") int userId);

    /**
     * 删除用户信息
     *
     * @param id
     */
    public void deleteNews(@Param("id") int id);

    /**
     * 查询消息详情
     *
     * @param isbn
     * @param userId
     */
    public TBorrow findDetailInfo(@Param("isbn") String isbn, @Param("userId") int userId);

    /**
     * 添加新的续借消息
     *
     * @param uId
     * @param isbn
     * @param date
     */
    public void addRenewNews(@Param("userId") int uId, @Param("isbn") String isbn, @Param("date") String date);

    /**
     * 添加新的借书消息
     *
     * @param uId
     * @param isbn
     * @param date
     */
    public void addBorrowNews(@Param("userId") int uId, @Param("isbn") String isbn, @Param("date") String date);

    /**
     * 添加新的还书消息2
     *
     * @param uId
     * @param isbn
     * @param date
     */
    public void addRevertNews(@Param("userId") int uId, @Param("isbn") String isbn, @Param("date") String date);

    /**
     * 查找isbn
     *
     * @param uId
     * @param id
     * @return
     */
    public TStore findIsbn(@Param("userId") int uId, @Param("id") int id);

    /**
     * 查找未读消息
     */
    public List<TBookNews> findNewsState();

    /**
     * 更新state状态
     * @param uId
     */
    public void updateState(@Param("userId") int uId);
}
