import java.util.ArrayList;

class NewClass{
	int newField;

	int getNewField() { 
		return newField;
	}	

	@Deprecated
	int oldField;

	@Deprecated
	int getOldField() { 
		return oldField;
	}
}


class AnnotationEx3 {
	@SuppressWarnings("deprecation")     // deprecation관련 경고를 억제
	public static void main(String args[]) {
		NewClass nc = new NewClass();

		nc.oldField = 10;                     //@Depreacted가 붙은 대상을 사용
		System.out.println(nc.getOldField()); //@Depreacted가 붙은 대상을 사용

		@SuppressWarnings("unchecked")               // 지네릭스 관련 경고를 억제
		ArrayList<NewClass> list = new ArrayList();  // 타입을 지정하지 않음.
		list.add(nc);
	}
}

