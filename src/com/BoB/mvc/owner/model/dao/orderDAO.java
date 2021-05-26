package com.BoB.mvc.owner.model.dao;

import static com.BoB.mvc.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.BoB.mvc.owner.model.dto.PageInfoDTO;
import com.BoB.mvc.common.config.ConfigLocation;

public class orderDAO {
	private Properties prop = new Properties();
	
	public orderDAO() {
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION+"owner/owner-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
