package com.sen.netty.lecture.thrift;

import com.sen.generated.DataException;
import com.sen.generated.Person;
import com.sen.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @author sen
 * @date 2020/7/1 23:53
 * @description 实现thrift中定义的接口
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("getPersonByUsername was called!");
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
