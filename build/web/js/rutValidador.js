class rutValidador{
    constructor(rut){
        this.rut=rut;
        //obtenemos el ultimo caracter del rut
        this.dv=this.rut.substring(this.rut.length-1);
        //limpiar rut dejar solo numeros
        this.rut=this.rut.substring(0 , this.rut.length-1).replace(/\D/g,'');
        this.esvalido=this.validar();
    }
    
    validar(){
        let numerosarray= this.rut.split('').reverse();
        let acumulador=0;
        let multiplicador=2;
        for(let numero of numerosarray){
            acumulador+=parseInt(numero)*multiplicador;
            multiplicador++;
            
            if(multiplicador==8){
                multiplicador=2;
            }
        }
        let dv=11-(acumulador%11);
        console.log('digito calculado',dv)
        console.log(numerosarray);
        
        if(dv==11)
            dv='0'
        if(dv==10)
            dv='k'
        
        return dv==this.dv.toLowerCase();
    }
    
    formato(){
        if(!this.esvalido) return '';
        
        return (this.rut.toString().replace(/\B(?=(\d{3})+(?!\d))/g,'.'))+'-'+this.dv;
    }
}

let validador=new rutValidador('30.686.957-4');

console.log ('numeros',validador.rut);
console.log ('digito verificador',validador.dv);
console.log (validador.esvalido);
console.log (validador.formato());

