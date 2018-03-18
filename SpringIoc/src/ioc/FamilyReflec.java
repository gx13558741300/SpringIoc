package ioc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FamilyReflec {

	List<Object> objectList;
	public FamilyReflec() {
		objectList = new ArrayList<Object>();
	}
	public void get_ref(Object object) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		Class<?> clazz = object.getClass();
	
		if (clazz.isAnnotationPresent(Entity.class)) {//�������Entityע��
			Field[] fields = clazz.getDeclaredFields();//��ȡ��Ա����
			for (Field field : fields) {
				if (field.isAnnotationPresent(Resources.class)) {
					//�������Resourcesע�ͣ�����Ҫע��
					Class<?> gxClass = Class.forName(field.getType().getName(),
							false, Thread.currentThread().getContextClassLoader());
					// װ�ض�Ӧ��Ա����������
					field.setAccessible(true);//ȡ��java���Է��ʼ�飬����private���εı���Ҳ�ܸ�ֵ��
					field.set(object,gxClass.newInstance());//���ݼ��ص��ഴ��ʵ��
					objectList.add(object); //����ʼ����ϵĶ��󱣴������
				}
			}
		}
	}
	public List<Object> getObjectList(){
		return this.objectList;
	}
}
