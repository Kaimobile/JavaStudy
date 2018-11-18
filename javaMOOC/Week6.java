package week6;

class ScoreException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ScoreException() {
		super();
	}
	
	public ScoreException(String str) {
		super(str);
	}
	
}

class Student {
	
	private String name;
	private int score;
	
	public Student() {
		super();
	}
	
	public Student(String name, int score) throws ScoreException {
		super();
		this.name = name;
		if(score >= 0 && score <= 100) {
			this.score = score;
		}else {
			throw new ScoreException("Wrong Score");
		}
	}
	
	public String showName() {
		return this.name;
	}
	public int showScore() {
		return this.score;
	}
}

public class Week6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Student LiMing = new Student("Liming",-1);
		}catch(ScoreException e) {
			e.printStackTrace();
		}
	}

}
