package org.keegsands.sportball.service.impl;

import org.keegsands.sportball.dao.FieldDAO;
import org.keegsands.sportball.model.Field;
import org.keegsands.sportball.service.FieldService;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl extends
		AbstractSimpleServiceImpl<Field, FieldDAO> implements FieldService {
	public void setFieldDAO(final FieldDAO fieldDAO) {
		super.setDAO(fieldDAO);
	}
}
