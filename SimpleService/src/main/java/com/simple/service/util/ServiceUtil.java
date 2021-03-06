package com.simple.service.util;

import java.util.List;

import com.simple.service.entity.SimpleServiceOrder;

public class ServiceUtil {

	public static SimpleServiceOrder getServiceById(final Long id, final List<SimpleServiceOrder> serviceOrderList) {
		SimpleServiceOrder simple = null;

		simple = serviceOrderList.stream().filter(os -> os.getId().equals(id)).findFirst().get();

		return simple;
	}

	public static SimpleServiceOrder getServiceByLabel(final String label,
			final List<SimpleServiceOrder> serviceOrderList) {

		SimpleServiceOrder simple = null;

		simple = serviceOrderList.stream().filter(os -> os.getLabel().equals(label)).findFirst().get();

		return simple;
	}

	public static SimpleServiceOrder getServiceIdByLabel(final String label,
			final List<SimpleServiceOrder> serviceOrderList) {
		return getServiceByLabel(label, serviceOrderList);
	}

}
