import myexeptions.WrongLoginException;
import myexeptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        try {
            check("Green", "123", "123");
            System.out.println("проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("Login должен содержать в себе " +
                    " только латинские буквы, цифры и знак подчеркивания");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("логин должен быть равен или меньше 20 символов");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("пароль  должен содержать в себе " +
                    "только латинские буквы, цифры и знак подчеркивания");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("пароль  должен быть равен или меньше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }

    }
}

/*
1. Напишите статический метод, который принимает на вход три параметра:
 login, password и confirmPassword.
2. Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
*Например, java_skypro_go.* У параметра login есть ограничение по длине
 – он должен быть равен или меньше 20 символов. Если login длиннее 20 символов
  или содержит в себе недопустимые символы, то необходимо выбросить исключение – `myexeptions.WrongLoginException`.
3. Параметр Password содержит в себе только латинские буквы, цифры
и знак подчеркивания. *Например, D_1hWiKjjP_9.* Если password длиннее 20 символов
или содержит в себе недопустимые символы, то необходимо выбросить исключение – `myexeptions.WrongPasswordException`.
4. Параметры password и confirmPassword должны быть равны. Если это требование
 не соблюдается, то нужно выбросить `myexeptions.WrongPasswordException`.
5. Для обработки исключений используйте multi-catch block.
6. Метод ничего не должен возвращать , если значения параметров
подходят под ограничения,  или бросать исключение, если условия не выполняются.
7. При вызове метода необходимо обработать потенциальные исключения.

- Критерии оценки
    - Статический метод принимает на вход три параметра
    - Метод принимает параметр Login , содержащий в себе только латинские буквы, цифры и знак подчеркивания
    - Метод принимает параметр Password , содержащий в себе только латинские буквы, цифры и знак подчеркивания
    - Если параметр Login содержит недопустимые символы или их длина больше 20 символов,
    то выбрасывается ошибка `myexeptions.WrongLoginException`
    - Если параметр Password содержит недопустимые символы или их длина больше 20 символов,
     то выбрасывается ошибка `myexeptions.WrongPasswordException`
    - Если параметры Password и confirmPassword  не равны, выбрасывается ошибка `myexeptions.WrongPasswordException`.
    - Исключения обработаны в multi-catch block.
 */