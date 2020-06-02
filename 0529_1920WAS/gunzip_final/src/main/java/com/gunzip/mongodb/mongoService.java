package com.gunzip.mongodb;

import java.util.ArrayList;

public interface mongoService {
	void insert(mongoDTO dto);
	ArrayList<mongoDTO> select(mongoDTO dto);
	void insertLog(mongoLogDTO dto);
}
