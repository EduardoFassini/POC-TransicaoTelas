Prova de Conceito (POC):
 Tipos de Navegação entre Telas em App’s utilizando Kotlin
 

Objetivo da POC
Esta POC foi criada para demonstrar diferentes abordagens de navegação entre telas em um aplicativo Android. Ele explora três métodos principais de navegação:
1.	Intents acionados por botões - para navegação direta entre telas.
2.	NavigationView com DrawerLayout - para navegação com menu lateral.
3.	TabLayout - para navegação entre abas.
Essas implementações são úteis em aplicativos onde é necessário alternar entre várias telas, oferecendo uma experiência fluida e organizada ao usuário. Foram elaboradas três telas, utilizando tais implementações para realizar a transição entre elas.

Estrutura da POC
1.	MainActivity - A Activity principal onde o projeto se inicia, representando a Tela 1. Ela configura a navegação com DrawerLayout e TabLayout e contém botões que utilizam Intents (objetos usados para permitir a comunicação entre diferentes componentes, que neste caso, indicam a inicialização de uma nova Activity) para abrir novas Activities.
2.	SecondActivity e ThirdActivity - Activities acessadas a partir do MainActivity, tanto pelos botões quanto pelas abas do TabLayout e itens do NavigationView, que possuem componentes iguais aos da MainActivity para transmitir a sensação que o menu lateral, as abas do TabLayout e os botões são os mesmos e seguem o mesmo padrão. O tabLayout de cada Activity é definido para selecionar a aba correspondente à tela quando ela é exibida, dentro do método onStart (Exemplo: estando na tela 1 e selecionando a aba “Tela 2”, a SecondActivity é aberta e a segunda aba de seu tabLayout é selecionada visualmente).

Principais Componentes e Implementação
1. NavigationView com DrawerLayout
•	DrawerLayout é um layout que permite deslizar um menu lateral a partir da borda da tela, comum para navegação em aplicativos Android.
•	NavigationView é o menu dentro do DrawerLayout, e contém itens de menu que representam cada Activity.
•	ActionBarDrawerToggle foi configurado para sincronizar o estado do botão "hambúrguer" no Toolbar com o DrawerLayout, abrindo e fechando o menu lateral.

2. TabLayout para Navegação por Abas
•	TabLayout é utilizado para alternar entre diferentes atividades. Cada aba, ao ser clicada, abre uma nova atividade. Isso foi configurado no código adicionando OnTabSelectedListener, onde a posição da aba determina qual atividade será iniciada.
•	As animações de transição (fade in e fade out) são aplicadas ao alternar entre atividades para uma experiência visual mais agradável e fluida.

3. Navegação com Intents e Botões
•	Dois botões foram configurados em cada Activity. Eles utilizam Intents para abrir as outras duas possíveis Activities.
•	Os Intents também contêm flags (FLAG_ACTIVITY_CLEAR_TOP e FLAG_ACTIVITY_SINGLE_TOP) para evitar a criação de múltiplas instâncias da mesma atividade ao navegar de volta. 

4. Considerações 
•	Navegação Intuitiva: A fácil navegação é garantida tendo uma boa usabilidade e exibindo as opções de navegação de maneira clara ao usuário.
•	Animações e Transições: As transições entre Activities foram configuradas para melhorar a experiência do usuário.
•	Uso de Flags de Intents: As flags evitam o empilhamento desnecessário de atividades na pilha de navegação.
