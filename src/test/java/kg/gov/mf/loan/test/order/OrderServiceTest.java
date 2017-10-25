package kg.gov.mf.loan.test.order;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

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
import kg.gov.mf.loan.manage.service.order.CreditOrderService;
import kg.gov.mf.loan.manage.service.order.CreditOrderStateService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= {AppConfig.class},  loader=AnnotationConfigWebContextLoader.class)
public class OrderServiceTest {

	@Autowired
	private CreditOrderService orderService;
	
	@Autowired
	private CreditOrderStateService stateService;
	
	@Test
	public void TestOrderService() {
		
		assertThat(orderService, instanceOf(CreditOrderService.class));
	}
	
	@Test
	public void TestOrderFindByRegNumber() {
		
		CreditOrder order = orderService.findByRegNumber("REG-1234");
		assertNotNull(order);
	}
	
	@Test
	public void TestOrderCreateState() {
		
		CreditOrderState state1 = new CreditOrderState("Testing state");
		stateService.save(state1);
		CreditOrderState state2 = stateService.findByName("Testing state");
		assertEquals(state1.getName(), state2.getName());
		stateService.deleteById(state2.getId());
	}
	
}
