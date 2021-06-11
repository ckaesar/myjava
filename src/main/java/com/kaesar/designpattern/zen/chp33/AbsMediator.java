package com.kaesar.designpattern.zen.chp33;

import com.kaesar.designpattern.zen.chp14.Sale;

/**
 * 抽象中介者
 *
 * @Author: chengk
 * @Date: 2021/5/29 12:52 下午
 */
public abstract class AbsMediator {
    // 工资
    protected final ISalary salary;

    // 职位
    protected final IPosition position;

    // 税收
    protected final ITax tax;

    public AbsMediator() {
        salary = new Salary(this);
        position = new Position(this);
        tax = new Tax(this);
    }

    // 工资增加了
    public abstract void up(ISalary _salary);

    // 职位提升了
    public abstract void up(IPosition _position);

    // 税收增加了
    public abstract void up(ITax _tax);

    // 工资降低了
    public abstract void down(ISalary _salary);

    // 职位降低了
    public abstract void down(IPosition _position);

    // 税收降低了
    public abstract void down(ITax _tax);
}