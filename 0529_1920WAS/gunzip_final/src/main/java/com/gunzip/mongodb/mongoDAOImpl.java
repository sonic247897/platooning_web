package com.gunzip.mongodb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class mongoDAOImpl implements mongoDAO {
	@Autowired
	MongoTemplate mongotemplate;
		
	@Override
	public void insert(mongoDTO dto) {
		mongotemplate.insert(dto);
	}

	@Override
	public ArrayList<mongoDTO> select(mongoDTO dto) {
		ArrayList<mongoDTO> list = new ArrayList<mongoDTO>();
		list = (ArrayList<mongoDTO>) mongotemplate.findAll(mongoDTO.class);
		return list;
	}

	@Override
	public void insertLog(mongoLogDTO dto) {
		mongotemplate.insert(dto);
	}
	
	
}