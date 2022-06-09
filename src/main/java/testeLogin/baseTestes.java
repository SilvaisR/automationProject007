package testeLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseTestes {

    public static By botaoSignIn = By.xpath("//*[@id='_desktop_user_info']/div/a/span");

    public static By campoEmail = By.name("email");
    public static By campoSenha = By.name("password");
    public static By botaoSubmit = By.id("submit-login");
    public static By hideName = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span");

    public static WebDriver driver;

    public static void main(String[] args) {

        testarLoginUsuario();

    }

    public static void testarLoginUsuario(){
        inicializar();
        carregarPaginaInicial();
        driver.findElement(botaoSignIn).click();
        fazerLogin();

        testVerificaSeEstaLogado();
    }

    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\102\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void carregarPaginaInicial(){
        driver.get("https://marcelodebittencourt.com/demoprestashop/");
    }

    public static void fazerLogin(){
        driver.findElement(campoEmail).sendKeys("silvanis@teste.com");
        driver.findElement(campoSenha).sendKeys("123456");
        driver.findElement(botaoSubmit).click();
    }

    public static void testVerificaSeEstaLogado(){
        String resultadoEsperado = ("Silvanis Silva");
        String resultadoObtido = driver.findElement(hideName).getText();

        if(resultadoEsperado.equals(resultadoObtido)){
            System.out.println("O usuário está logado.");
        } else {
            System.out.println("O usuário não está logado.");
        }


    }


}
