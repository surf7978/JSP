package co.micol.minipro.common;

import java.util.ArrayList;

public interface DbInterface<T> {
	public ArrayList<T> selectList(); //내가 만든타입 = T , Element타입 = E, ? = 아직 타입 설정안해서 인터페이스 쓸때마다 결정해주면 됨
	public T select(T vo);
	public int insert(T vo);
	public int update(T vo);
	public int delete(T vo);
}
