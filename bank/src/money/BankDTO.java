package money;

public class BankDTO {
	String id;
	String name;
	String age;
	String tel;
	
	public BankDTO() {
		
	}
	
	public BankDTO(String id, String name, String age, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	String getId() {
		return id;
	}
	void setId(String id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getAge() {
		return age;
	}
	void setAge(String age) {
		this.age = age;
	}
	String getTel() {
		return tel;
	}
	void setTel(String tel) {
		this.tel = tel;
	}
}
