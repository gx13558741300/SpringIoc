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
	
		if (clazz.isAnnotationPresent(Entity.class)) {//如果带有Entity注释
			Field[] fields = clazz.getDeclaredFields();//获取成员变量
			for (Field field : fields) {
				if (field.isAnnotationPresent(Resources.class)) {
					//如果带有Resources注释，则需要注入
					Class<?> gxClass = Class.forName(field.getType().getName(),
							false, Thread.currentThread().getContextClassLoader());
					// 装载对应成员变量的类型
					field.setAccessible(true);//取消java语言访问检查，对于private修饰的变量也能赋值了
					field.set(object,gxClass.newInstance());//根据加载的类创建实例
					objectList.add(object); //将初始化完毕的对象保存进容器
				}
			}
		}
	}
	public List<Object> getObjectList(){
		return this.objectList;
	}
}
