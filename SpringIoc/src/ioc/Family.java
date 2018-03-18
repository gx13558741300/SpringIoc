package ioc;

@Entity
public class Family {
	@Resources
	private Gx gx;//private 会报错，无法通过反射创建实例，
	//问题在于应该先调用setAccessible(true)方法取消java语言访问检查
	
	public void familySay() {
		gx.say();
	}
}
