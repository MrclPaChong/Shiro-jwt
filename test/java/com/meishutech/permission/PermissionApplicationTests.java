package com.meishutech.permission;

import com.meishutech.permission.dao.PermissionDao;
import com.meishutech.permission.dao.UserDao;
import com.meishutech.permission.util.tools.StringTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionApplicationTests {
    @Autowired
    private PermissionDao permissionDao;
    /*
        long begin;
        long end;
    */
    @Autowired
    private UserDao userDao;


    @Test
    public void ss(){
        List<String> res =  userDao.gradeByPermissionParentId("10");
        String res2 = userDao.queryExistmenuName("财务");
        if (StringTools.isNullOrEmpty(res2)){
            System.out.println("null-----------------");
        }
        else {
            System.out.println("youzhi ");
        }
        System.out.println(res2+"+++++++++++++++++++++++");
        for (String grade : res){

            if (!StringTools.isNullOrEmpty(grade)){
                int newGrade = Integer.valueOf(grade) +1;
                System.out.println(res+"*****"+newGrade);
                break;
            }

        }

    }

    @Test
    public void contextLoads() {

        String uid = UUID.randomUUID().toString();
        System.out.println( uid);
        System.out.println(permissionDao.getAnonymousMenu("usertopermission"));
        System.out.println(permissionDao.getAnonymousPermission("usertopermission"));


    }


}
