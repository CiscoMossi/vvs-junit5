## **Plano de testes**

| Teste       | Entrada | Saída esperada |
| ----------- | ---------- | ---------- | 
| Registrar usuário válido | { name: "Nome", email: "abc@abc.com.br", password: "12345678", passwordConfirmation: "12345678" } | status code 201 |
| Registrar usuário nome inválido | { name: "", email: "abc@abc.com.br", password: "12345678", passwordConfirmation: "12345678" } | status code 400, mensagem "Nome inválido" |
| Registrar usuário email inválido | { name: "Nome", email: "abc", password: "12345678", passwordConfirmation: "12345678" } | status code 400, mensagem "Email inválido" |
| Registrar usuário senha inválida | { name: "Nome", email: "abc@abc.com.br", password: "1234", passwordConfirmation: "1234" } | status code 400, mensagem "Senha inválida" |
| Registrar usuário confirmação de senha inválida | { name: "Nome", email: "abc@abc.com.br", password: "12345678", passwordConfirmation: "1234567890" } | status code 400, mensagem "Confirmação de senha inválida" |
| Registrar usuário confirmação de senha errada | { name: "Nome", email: "abc@abc.com.br", password: "12345678", passwordConfirmation: "1234567890" } | status code 400, mensagem "As senhas não conferem" |
| Registrar usuário | sem body | status code 400, mensagem "Usuário inválido" |
