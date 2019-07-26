import mockit.Mock
import mockit.MockUp
import spock.lang.Specification

class MessageServiceSpec extends Specification {

	MockUp<MessageService> mockMessageService
	def messageService = new MessageService()

	def 'Should not be run'() {
		expect: 'Should return  the correct message'
		println 'Should not be run'
		messageService.getMessage() == 'Hello World!'
	}

	void mockMessageService(){
		mockMessageService = new MockUp<MessageService>() {
					@Mock public String mockMethod(String strValue) {
						return "This is mock result"
					}
				}
	}

	def'API to Test Mocking'(){
		given:'Instance of MessageService'
		when :'MessageService.mockMethod is called'
			mockMessageService()
		then : 'It will return true'
			messageService.mockMethod("Test") == 'This is mock result'
	}
	
	def 'API to add numbers'() {
		given:'Instance of MessageService and number as string'
		when :'MessageService.Add is called with parameters'
			int nTotal = messageService.Add(strValues)
		then : 'It will return true'
			nTotal == result
		where:
			strValues   		|   	  result
				""  			|   		0		
				"2,6"			|			8			
				"2,6,8"			|			16		
	}
	
}