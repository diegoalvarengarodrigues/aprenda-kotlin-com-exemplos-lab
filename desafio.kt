// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun inscreverSe(usuario: Usuario) {
        inscritos.add(usuario)
    }
    fun listaDeFormacoes(){
        for (cont in conteudos){
            println("${cont.nome} : ${cont.duracao}")
        }
    }
    fun listaDeIncritos(): List<String> {
        val lista = mutableListOf<String>()
        for (user in inscritos){
            lista.add(user.toString())
        }
        return lista
    }
}

fun main() {
    val formacaoJAVA = ConteudoEducacional("Formação Java", 50, Nivel.AVANÇADO)
    val cursoHTML = ConteudoEducacional("Curso de HTML", 20, Nivel.BASICO)
    val cursoMySql = ConteudoEducacional("Curso de MySql", 35, Nivel.INTERMEDIARIO)

    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(cursoHTML)
    listConteudos.add(cursoMySql)
    listConteudos.add(formacaoJAVA)

    val Jorge = Usuario("Jorge", "jorge@hotmail.com")
    val Marcela = Usuario("Marcela", "marcela@gmail.com")
    val Gael = Usuario("Gael", "gael@gmail.com")

    val formacaoBackEndDeveloper = Formacao("Formação BackEnd Developer", listConteudos)
    val formacaoFrontEndDeveloper = Formacao("Formação FrontEnd Developer", listConteudos)
    val formacaoGit = Formacao("Formação Git ", listConteudos)

    formacaoBackEndDeveloper.inscreverSe(Jorge)
    formacaoFrontEndDeveloper.inscreverSe(Marcela)
    formacaoGit.inscreverSe(Gael)

    print("Formação: ")
    println("${formacaoBackEndDeveloper.nome}")
    println("${formacaoFrontEndDeveloper.nome}")
    println("${formacaoGit.nome}")
    println()

    println("Nome e Email dos Incritos :  ")
    for (usuario in formacaoBackEndDeveloper.listaDeIncritos()) {
        println(usuario)
    }
    println("\"${formacaoBackEndDeveloper.nome}\"")
    println()
    for (usuario in formacaoFrontEndDeveloper.listaDeIncritos()) {
        println(usuario)
    }
    println("\"${formacaoFrontEndDeveloper.nome}\"")
    println()
    for (usuario in formacaoGit.listaDeIncritos()) {
        println(usuario)
    }
    println("\"${formacaoGit.nome}\"")




}
