package kg.gov.mf.loan.test.order;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import kg.gov.mf.loan.config.AppConfig;
import kg.gov.mf.loan.manage.model.order.CreditOrder;
import kg.gov.mf.loan.manage.model.order.CreditOrderState;
import kg.gov.mf.loan.manage.model.order.CreditOrderType;
import kg.gov.mf.loan.manage.service.order.CreditOrderService;
import kg.gov.mf.loan.manage.service.order.CreditOrderStateService;
import kg.gov.mf.loan.manage.service.order.CreditOrderTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {AppConfig.class},  loader=AnnotationConfigWebContextLoader.class)
public class OrderServiceTest {

	@Autowired
	private CreditOrderService orderService;
	
	@Autowired
	private CreditOrderStateService stateService;
	
	@Autowired
	private CreditOrderTypeService typeService;
	
	@Test
	public void TestOrderService() {
		
		assertThat(orderService, instanceOf(CreditOrderService.class));
	}
	
	@Test
	public void TestOrderFindByRegNumber() {
		
		CreditOrder order = orderService.findByRegNumber("REG-1234");
		assertNotNull(order);
	}
	
	/*
	@Test
	public void TestOrderCreateOrder() {
		
		CreditOrderState state1 = new CreditOrderState("Статус 1");
		stateService.save(state1);
		CreditOrderState state2 = stateService.findByName("Статус 1");
		assertEquals(state1.getName(), state2.getName());
		
		CreditOrderType type1 = new CreditOrderType("Testing type");
		typeService.save(type1);
		CreditOrderType type2 = typeService.findByName("Testing type");
		assertEquals(type1.getName(), type2.getName());
		
		CreditOrder order = new CreditOrder("REG12345", new Date(0), "Кредит", state2, type2);
		orderService.save(order);
		CreditOrder order2 = orderService.findByRegNumber("REG12345");
		assertEquals(order, order2);
	}
	*/
	
}
