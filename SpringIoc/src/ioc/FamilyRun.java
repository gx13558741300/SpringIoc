package ioc;

public class FamilyRun {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		FamilyRun familyRun = new FamilyRun();
		Family family = (Family)familyRun.springGo();
		family.familySay();
		
	}
	public Object springGo() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		FamilyReflec familyReflec = new FamilyReflec();//����ioc
		Family family = new Family();
		familyReflec.get_ref(family);//װ��family
		Object object = familyReflec.getObjectList().get(0);//��ȡfamilyʵ��
		return object;
	}
}
