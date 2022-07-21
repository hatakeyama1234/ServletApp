package scopedata;

public class u_Login {
	private String login_id;
	private String pw;
	public u_Login() {}
	public u_Login( String _login_id , String _pw ) {
		login_id = _login_id; pw = _pw;
	}
	public String getId()  { return login_id;  }
	public String getPass(){ return pw;}
}
