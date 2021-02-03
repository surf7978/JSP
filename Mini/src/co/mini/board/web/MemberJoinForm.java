package co.mini.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.board.common.Command;
import co.mini.board.common.DAO;

public class MemberJoinForm extends DAO implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "join/memberJoin";
	}

}
