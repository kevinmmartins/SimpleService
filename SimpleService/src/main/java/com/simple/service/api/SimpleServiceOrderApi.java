package com.simple.service.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.service.entity.SimpleServiceOrder;
import com.simple.service.entity.to.EntityId;
import com.simple.service.util.ServiceUtil;

@RestController
@RequestMapping("/serviceorder")
public class SimpleServiceOrderApi {

	private List<SimpleServiceOrder> serviceOrderList;

	public SimpleServiceOrderApi() {
		serviceOrderList = new ArrayList<>();
		serviceOrderList.add(new SimpleServiceOrder(1l, "2017-1", "Mogi Guaçu"));
		serviceOrderList.add(new SimpleServiceOrder(2l, "2017-2", "Limeira"));
	}

	@RequestMapping(value = "/so/", method = RequestMethod.GET)
	public ResponseEntity<List<SimpleServiceOrder>> getAllServiceOrders() {
		return new ResponseEntity<List<SimpleServiceOrder>>(serviceOrderList, HttpStatus.OK);
	}

	@RequestMapping(value = "/so/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<SimpleServiceOrder> findById(@PathVariable("id") Long id) {

		SimpleServiceOrder simple = null;

		try {
			simple = ServiceUtil.getServiceById(id, serviceOrderList);

			if (simple == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<SimpleServiceOrder>(simple, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/so/label/{label}", method = RequestMethod.GET)
	public ResponseEntity<EntityId> findByLabel(@PathVariable("label") String label) {

		try {
			SimpleServiceOrder simple = ServiceUtil.getServiceIdByLabel(label, serviceOrderList);

			if (simple == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<EntityId>(new EntityId(simple), HttpStatus.OK);

		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/so/", method = RequestMethod.POST)
	public ResponseEntity<Void> newServiceOrder(@RequestBody SimpleServiceOrder newSimple) {
		serviceOrderList.add(newSimple);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
