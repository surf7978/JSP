--micol계정에 hr꺼를 조회할수 있게 권한 주기
--cmd에서 sqlplus / as sysdba
-- grant select on hr.employees to micol;

select *  from hr.employees;

create table employees
as
select * from hr.employees;

create table salary_history(
 employee_id number(6,0),
 before_salary number(8,2),
 current_salary number(8,2),
 change_date date
);

commit;

CREATE OR REPLACE PROCEDURE SAL_HISTORY_PROC 
(
  P_EMP_ID IN NUMBER 
, P_SALARY IN NUMBER 
, R_EMPLOYEE OUT SYS_REFCURSOR 
) AS 
v_salary employees.salary%type;

BEGIN
  dbms_output.put_line('step1');
  --1.p_emp_id의 현재 급여
  begin
    select salary
    into v_salary
    from employees
    where employee_id = p_emp_id;
  END;
  
  dbms_output.put_line('step2');
  --2.p_emp_id의 급여변경
  begin
    update employees
    set salary = p_salary
    where employee_id = p_emp_id;
  end;
  
  dbms_output.put_line('step3');
  --3.salary_history에 넣기
  begin
    insert into salary_history values(p_emp_id, v_salary, p_salary, sysdate);
  end;
  
  dbms_output.put_line('step4');
  --4.변경된 정보를 조회
  begin
    open r_employee for select e.* from employees e where employee_id = p_emp_id;
    exception
      when others then
        DBMS_OUTPUT.PUT_LINE('step4 => ' || sqlerrm );
  end;
  commit;
  exception
    when others then
      DBMS_OUTPUT.PUT_LINE('salary_history_proc => ' || sqlerrm );
END SAL_HISTORY_PROC;
/

select * from employees where employee_id = 101;

select employee_id, BEFORE_SALARY, CURRENT_SALARY
       , to_char(change_date, 'yyyy-mm-dd hh24:mi:ss') c_date
from salary_history;

