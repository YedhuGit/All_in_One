package Web.Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class HomeFunctions {

    public void taking_all_apiresponse(){

    }
    public String getXPathByVisibleText(WebDriver driver, String visibleText) {
        try {
            // Find the element using visible text
            WebElement element = driver.findElement(By.xpath("//*[normalize-space(text())='" + visibleText + "']"));

            // Use JavaScript to compute absolute XPath
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script =
                    "function absoluteXPath(element) {" +
                            "var comp, comps = [];" +
                            "var parent = null;" +
                            "var xpath = '';" +
                            "var getPos = function(element) {" +
                            "var position = 1, curNode;" +
                            "if (element.nodeType == Node.ATTRIBUTE_NODE) {" +
                            "return null;}" +
                            "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {" +
                            "if (curNode.nodeName == element.nodeName) {++position;}}" +
                            "return position;};" +
                            "if (element instanceof Document) {return '/';}" +
                            "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {" +
                            "comp = comps[comps.length] = {};" +
                            "switch (element.nodeType) {" +
                            "case Node.TEXT_NODE:" +
                            "comp.name = 'text()'; break;" +
                            "case Node.ATTRIBUTE_NODE:" +
                            "comp.name = '@' + element.nodeName; break;" +
                            "case Node.ELEMENT_NODE:" +
                            "comp.name = element.nodeName; break;" +
                            "}" +
                            "comp.position = getPos(element);" +
                            "}" +
                            "for (var i = comps.length - 1; i >= 0; i--) {" +
                            "comp = comps[i];" +
                            "xpath += '/' + comp.name.toLowerCase();" +
                            "if (comp.position !== null && comp.position > 1) {" +
                            "xpath += '[' + comp.position + ']';}}" +
                            "return xpath;" +
                            "}" +
                            "return absoluteXPath(arguments[0]);";

            String xpath = (String) js.executeScript(script, element);
            return xpath;
        } catch (NoSuchElementException e) {
            return "❌ Element with text '" + visibleText + "' not found!";
        }
    }

}
