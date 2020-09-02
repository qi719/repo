package com.heima.behavior.test;

import com.heima.behavior.BehaviorJarApplication;
import com.heima.behavior.service.AppShowBehaviorService;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.behavior.dtos.ShowBehaviorDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.utils.threadlocal.AppThreadLocalUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)

public class BehaviorTest {

    @Autowired
    private AppShowBehaviorService appShowBehaviorService;
    @Transactional
    @Test
    @Rollback(value = false)

    public void testSave(){
        ApUser user = new ApUser();
        user.setId(1l);
        AppThreadLocalUtils.setUser(user);
        ShowBehaviorDto dto = new ShowBehaviorDto();
        List<ApArticle> list = new ArrayList<>();
        ApArticle apArticle = new ApArticle();
        apArticle.setId(200);
        list.add(apArticle);
        dto.setArticleIds(list);
        appShowBehaviorService.saveShowBehavior(dto);
        System.out.println("1");
    }
}
