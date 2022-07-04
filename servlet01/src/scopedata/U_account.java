package scopedata;

public class U_account {
	public String login_id;
	public String pw;
	public U_account(String _login_id,String _pw) {
		login_id= _login_id; pw= _pw;
	}
	public String getLogin_id() {return login_id;}
	public String getPw() {return pw;}


	public void setLogin_id(String _login_id) { login_id= _login_id;}
	public void setPw(String _pw) {	pw= _pw;}

}
