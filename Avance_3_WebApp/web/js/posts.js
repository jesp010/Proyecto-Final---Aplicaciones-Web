class PostsManager {
    constructor() {
        this.sectionAnclados = document.getElementById("sectionAnclados");
        this.sectionComunes = document.getElementById("sectionComunes")
        this.renderAnclados();
        this.renderComunes();
    }
    
    renderAnclados() {
        this.getPostsAnclados().then((anclados) => {
            this.sectionAnclados.innerHTML = '';

            anclados.forEach((post) => {
                this.sectionAnclados.innerHTML += 
                `<article class="admin-post" post-id="${post.id}">
                    <p>by: <strong><span class="user-email">${post.usuarioAdministrador.correo}</span></strong></p>\n
                    <h2>${post.titulo}</h2>
                    <p>${post.contenido}</p>
                 </article>
                `;
            });
        })
    }
    
    renderComunes(){
        this.getPostsComunes().then((comunes) => {
            this.sectionComunes.innerHTML = '';
            
            comunes.forEach((post) => {
                this.sectionComunes.innerHTML += `
                <article class="normal-post" post-id="${post.id}">
                    <p>by: <strong><span class="user-email">${post.usuario.correo}</span></strong></p>
                    <h2>${post.titulo}</h2>
                    <p>${post.contenido}</p>
                 </article>
                `;
            })
        })
    }
    
    

    getPostsAnclados() {
        return fetch('/blog/posts?action=anclados')
                .then((res) => res.json())
                .then((res) => {
                    return res;
                })
                .then()
                .catch((err) => {
                    console.log(err);
                    alert('No se obtuvieron los posts :(')
                });
    }

    getPostsComunes() {
        return fetch('/blog/posts?action=comunes')
                .then((res) => res.json())
                .then((res) => {
                    return res;
                })
                .then()
                .catch((err) => {
                    console.log(err);
                    alert('No se obtuvieron los posts :(')
                });
    }
    
    printPostsComunes(){
        this.getPostsComunes()
                .then((res) => res.forEach((item) => console.log(item)));
    }
    
    printPostsAnclados(){
        this.getPostsAnclados()
                .then((res) => res.forEach((item) => console.log(item)));
    }
}

window.onload = () => new PostsManager();