

const selecionar_sector = document.getElementById("sector");
const cadastrar_sector = document.getElementById("cadastrar_sector");

selecionar_sector.addEventListener("change",function(){
    if(this.value !== 0){
        cadastrar_sector.style.display = "block";
    }
});



