package cucumber

import Calculator
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert
import kotlin.math.abs
import kotlin.properties.Delegates

class MultThreeTests {

    private var firstNumber by Delegates.notNull<Double>()
    private var secondNumber by Delegates.notNull<Double>()
    private var thirdNumber by Delegates.notNull<Double>()
    private var resultNumber by Delegates.notNull<Double>()

    @Given("a first number2 {double}")
    fun `a first number`(number: Double) {
        firstNumber = number
    }

    @And("a second number2 {double}")
    fun `a second integer`(number: Double) {
        secondNumber = number
    }

    @And("a third number2 {double}")
    fun `a third integer`(number: Double) {
        thirdNumber = number
    }

    @When("numbers multiplication")
    fun `numbers multiplication`() {
        resultNumber = Calculator().multiplicationThree(firstNumber, secondNumber, thirdNumber)
    }

    @Then("the result2 is {double}")
    fun `the result2 is`(result: Double) {
        MatcherAssert.assertThat(result, equalTo(resultNumber))
    }
}
