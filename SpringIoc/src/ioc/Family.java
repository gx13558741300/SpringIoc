package ioc;

@Entity
public class Family {
	@Resources
	private Gx gx;//private �ᱨ���޷�ͨ�����䴴��ʵ����
	//��������Ӧ���ȵ���setAccessible(true)����ȡ��java���Է��ʼ��
	
	public void familySay() {
		gx.say();
	}
}
