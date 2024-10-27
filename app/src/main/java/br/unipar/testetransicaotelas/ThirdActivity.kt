package br.unipar.testetransicaotelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class ThirdActivity : AppCompatActivity() {

    //Declaração da variável do Drawer Layout, que é um contêiner de layout que permite que você deslize um menu do lado da tela
    private lateinit var drawerLayout: DrawerLayout
    //Declaração da variável do Navigation View, que é o menu aberto na lateral da tela
    private lateinit var navView: NavigationView
    //Declaração da variável do Action Bar Drawer Toggle, que fornece a sincronização do estado da Toolbar com a DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Inicialização do DrawerLayout e NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navViewTelas)
        // Inicialização do TabLayout e dos botões para navegação
        val tabLayout = findViewById<TabLayout>(R.id.tabTelas)
        val btn1 = findViewById<Button>(R.id.btnTela1)
        val btn2 = findViewById<Button>(R.id.btnTela2)

        // Adição de abas no TabLayout com nomes personalizados
        tabLayout.addTab(tabLayout.newTab().setText("Tela 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tela 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tela 3"))

        /// Configuração da Toolbar (componente de barra de ferramentas que pode conter outros elementos como botões, menus e textos) como ActionBar da Activity, ou seja, como menu desta tela.
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarTelas)
        setSupportActionBar(toolbar)

        // Configuração do ActionBarDrawerToggle para controle do DrawerLayout
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle) // Associa do Drawer Toggle com o Drawer Layout
        toggle.syncState()                     // Sincroniza o estado do Drawer Toggle com o Drawer Layout

        // Configurações dos botões para abrir a Second e a Third Activity ao serem clicados
        btn1.setOnClickListener(){
            val intent = Intent(this@ThirdActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        btn2.setOnClickListener(){
            val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Lidar com cliques nos itens do NavigationView
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tela1 -> {
                    // Abre a MainActivity ao selecionar "Tela 1"
                    val intent = Intent(this@ThirdActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }

                R.id.tela2 -> {
                    // Abre a SecondActivity ao selecionar "Tela 2"
                    val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
            }
            drawerLayout.closeDrawers() // Fecha o drawer ao selecionar
            true
        }

        // Configuração de listener que verifica quando há mudança de abas no TabLayout
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        // Abre a MainActivity ao selecionar "Tela 1"
                        val intent = Intent(this@ThirdActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }

                    1 -> {
                        // Abre a SecondActivity ao selecionar "Tela 2"
                        val intent = Intent(this@ThirdActivity, SecondActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    }

                    2 -> {
                        // Permanece na ThirdActivity ao selecionar "Tela 3"
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Sem ação necessária ao desmarcar uma aba
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Sem ação necessária ao re-selecionar uma aba
            }
        })
    }

    // Método onStart para configurar o estado do Tab Layout e do Navigation View quando a Tela é aberta
    override fun onStart() {
        super.onStart()
        val tabLayout = findViewById<TabLayout>(R.id.tabTelas)
        tabLayout.getTabAt(2)?.select()  // Deixa a aba "Tela 3" selecionada
    }

    // Sincroniza o estado do Drawer Toggle com as mudanças do Drawer Layout
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }


    // Controla o botão de voltar do dispositivo para fechar o Drawer antes de sair da Activity
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(navView)) {
            drawerLayout.closeDrawers()  // Fecha o Drawer se estiver aberto
        } else {
            super.onBackPressed() // Usa o comportamento padrão do botão "voltar"
        }

    }

}
