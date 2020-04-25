package com.softdev.system.demo.repository;

import com.softdev.system.demo.entity.WsSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*  ws_site
* @author 大狼狗 2020-01-14
*/
@Repository
public interface WsSiteRepository extends JpaRepository<WsSite,String> {

    @Query(value = "select * from ws_site t where t.site_id=?1",nativeQuery = true)
    public List<WsSite> findWsSiteUser(String siteId);

}
