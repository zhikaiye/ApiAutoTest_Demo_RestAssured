package com.kk.wework.contact;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class DepartmentTest {

    static Department department;

    @BeforeClass
    public void tearDown(){
        department = new  Department();
    }

    @Test
    public void testList() {
        department.list("").then().statusCode(200).body("department.id[0]",equalTo(1));
    }

    @Test
    public void testCreate() {
        department.create("厦门","5");
    }

    @Test
    public void testUpdate() {
        department.update("2","测试部","1","2").then().statusCode(200);
    }

    @Test
    public void testDelete() {
        department.delete("2");
    }
}