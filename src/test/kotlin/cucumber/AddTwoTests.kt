import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import kotlin.math.abs
import kotlin.properties.Delegates

class CucumberTests {

    private var firstNumber by Delegates.notNull<Double>()
    private var secondNumber by Delegates.notNull<Double>()
    private var resultNumber by Delegates.notNull<Double>()

    @Given("a first number {double}")
    fun `a first number`(number: Double) {
        firstNumber = number
    }

    @And("a second number {double}")
    fun `a second integer`(number: Double) {
        secondNumber = number
    }

    @When("numbers added")
    fun `numbers added`() {
        resultNumber = Calculator().addTwo(firstNumber, secondNumber)
    }

    @Then("the result is {double}")
    fun `the result is`(result: Double) {
        val eps = abs(resultNumber - result)
        MatcherAssert.assertThat(true.toString(), eps < 0.000001 )
    }

}
