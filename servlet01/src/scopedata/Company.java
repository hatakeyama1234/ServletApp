package scopedata;

import java.io.Serializable;

public class Company implements Serializable{
	private String id;
	private String company;
	private String area;
	private String year;
	private String industry;
	private String pdf;

	public Company() {}
	public Company( String _id , String _company , String _area , String _year , String _industry , String _pdf) {
		id = _id; company = _company; area = _area; year = _year; industry = _industry; pdf = _pdf;
	}

	public String getId() {return id;}
	public String getCompany() {return company;}
	public String getArea() {return area;}
	public String getYear() {return year;}
	public String getIndustry() {return industry;}
	public String getPdf() {return pdf;}
}
