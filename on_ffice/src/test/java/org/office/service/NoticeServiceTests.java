package org.office.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.office.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeServiceTests {
	
	@Autowired
	private NoticeService service;
	
	//@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	//@Test
	public void testList() {
		
		service.list();
	}
	
	@Test
	public void testWrite() {
		
		NoticeVO vo = new NoticeVO();
		
		vo.setId(100001);
		vo.setBtitle("글제목");
		vo.setBcontent("글내용");
		vo.setName("아무개");
		vo.setPosition("사원");
		vo.setDpname("관리부");
		vo.setImportance("일반");
		
		service.write(vo);
	}
	

}
