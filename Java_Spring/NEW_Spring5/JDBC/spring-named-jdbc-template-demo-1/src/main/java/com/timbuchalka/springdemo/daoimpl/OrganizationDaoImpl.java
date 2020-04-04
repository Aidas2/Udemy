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

//@Repository("orgDao")
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

//	private JdbcTemplate jdbcTemplate; 							// for not named jdbc template
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;	// for named jdbc template

	@Autowired
	public void setDataSource(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean create(Organization org) {
//		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
//				"VALUES(?, ?, ?, ?, ?)";
//		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
//				org.getEmployeeCount(), org.getSlogan()};
//		return jdbcTemplate.update(sqlQuery, args) == 1;

		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
				"VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan)";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public Organization getOrganization(Integer id) {
//		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " +
//				"FROM organization WHERE id = ?";
//		Object[] args = new Object[] {id};
//		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
//		return org;

		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " +
				"FROM organization WHERE id = :ID";
		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
//		String sqlQuery = "SELECT * FROM organization";
//		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
//		return orgList;

		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
//		String sqlQuery = "DELETE FROM organization WHERE id = ?";
//		Object[] args = new Object[] { org.getId() };
//		return jdbcTemplate.update(sqlQuery, args) == 1;

		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Organization org) {
//		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
//		Object[] args = new Object[] { org.getSlogan(), org.getId() };
//		return jdbcTemplate.update(sqlQuery, args) == 1;

		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
//		String sqlQuery = "TRUNCATE TABLE organization ";
//		jdbcTemplate.execute(sqlQuery);

		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}