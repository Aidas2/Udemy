package com.timbuchalka.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
					"VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";

		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
		
//		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
//							org.getEmployeeCount(), org.getSlogan()};
//		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " +
				"FROM organization WHERE id = :ID";

		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
		
//		Object[] args = new Object[] {id};
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		
		return orgList;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
		
//		Object[] args = new Object[] { org.getId() };
	}

	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);		
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
		
//		Object[] args = new Object[] { org.getSlogan(), org.getId() };
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}
