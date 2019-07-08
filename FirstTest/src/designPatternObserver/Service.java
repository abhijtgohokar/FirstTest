package designPatternObserver;

public class Service {

	public static void main(String[] args) {
		SubjectObservable observable = new SubjectObservable();
		Observer observer = new Observer();
		
		observable.setObserver(observer);
		observable.setName("abc");
	}
}
