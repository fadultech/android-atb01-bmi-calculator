package tech.fadul.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Criando os atributos que são os representantes dos componentes
    // O VS não permite alterações diretamente nos componentes da tela
    // (variáveis que vão receber os componentes)
    private TextView textoResultado;
    private EditText editaPeso, editaAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associa os atributos (representantes) com os componentes da interface
        // (as variáveis recebem os conteúdos dos componentes da tela)
        // Os componentes da interface estão agrupados na classe R (Recursos)
        // View == Componente
        // findViewBy Id - procura um componente pelo seu id
        textoResultado = findViewById(R.id.textResultado);
        editaPeso = findViewById(R.id.editPeso);
        editaAltura = findViewById(R.id.editAltura);
    }

    // Cria método chamado pelo button - executa ações
    // View permite que o método seja "visto" pela interface
    // Aparece nas propriedades do botão
    public void calculaIMC(View view) {
        // Faz um Casting - converte string para double
        double peso = Double.parseDouble(editaPeso.getText().toString());
        double altura = Double.parseDouble(editaAltura.getText().toString());

        // Calcula o IMC
        double resultado = peso / (altura * altura);

        // Compara o resultado com os dados tabelados do IMC
        if (resultado < 19)                    { textoResultado.setText("Abaixo do Peso"); }
        if (resultado >= 19 && resultado < 25) { textoResultado.setText("Peso Normal"); }
        if (resultado >= 25 && resultado < 30) { textoResultado.setText("Sobrepeso"); }
        if (resultado >= 30 && resultado < 40) { textoResultado.setText("Obesidade do Tipo 1"); }
        if (resultado >= 40)                   { textoResultado.setText("Obesidade Mórbida"); }


    }
}