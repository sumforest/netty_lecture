from py.thrift.generated import PersonService
from py.thrift.generated import ttypes

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol

import sys
reload(sys)
sys.setdefaultencoding('utf8')

try:
    tSocket = TSocket.TSocket('localhost', 8899)
    tSocket.setTimeout(600)

    transport = TTransport.TFramedTransport(tSocket)
    protocol = TCompactProtocol.TCompactProtocol(transport)
    client = PersonService.Client(protocol)

    transport.open()

    person = client.getPersonByUsername("zhangsan")

    print person.username
    print person.age
    print person.married

    print '--------------------------'

    newPerson = ttypes.Person()
    newPerson.username = 'lisi'
    newPerson.age = 22
    newPerson.married = True

    client.savePerson(newPerson)
    transport.close()
except Thrift.TException, tx:
    print '%s' % tx.message
