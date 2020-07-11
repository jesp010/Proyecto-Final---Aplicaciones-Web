class PostsManager {
    constructor() {
        this.sectionAnclados = document.getElementById("sectionAnclados");
        this.sectionComunes = document.getElementById("sectionComunes");
        this.postForm = document.getElementById("post-form");
        this.userType = document.getElementById("usuario-data").getAttribute("tipo-usuario");
        this.usuarioEmail = document.getElementById("usuario-email").innerText;
        this.renderAnclados();
        this.renderComunes();
        this.post();
        this.addEvtListeners();
    }

    post() {
        this.postForm.addEventListener("submit", (evt) => {
            evt.preventDefault();
            let formTitulo = this.postForm.elements[0].value;
            let formContenido = this.postForm.elements[1].value;

            if (!(formTitulo.length < 4)) {
                if (!(formContenido.length < 7)) {
                    let http = new XMLHttpRequest();
                    console.log(this.userType)
                    let url = `/blog/posts?action=post&titulo=${formTitulo}&contenido=${formContenido}&usertype=${this.userType}&usuarioemail=${this.usuarioEmail}`;
                    http.open("POST", url);
                    http.send();

                    alert('Post Exitoso!')
                } else
                    alert('Contenido del post muy corto');
            } else
                alert("Titulo muy corto");
        });
    }

    renderAnclados() {
        this.getPostsAnclados().then((anclados) => {
            this.sectionAnclados.innerHTML = '';

            if (this.userType == "ObjetosNegocio.UsuarioNormal") {
                anclados.forEach((post) => {
                    this.sectionAnclados.innerHTML +=
                            `<article class="admin-post" post-id="${post.id}">
                        <p>by: <strong><span class="user-email">${post.usuarioAdministrador.correo}</span></strong></p>\n
                        <h2>${post.titulo}</h2>
                        <p>${post.contenido}</p>
                     </article>
                    `;
                });
            } else if (this.userType == "ObjetosNegocio.UsuarioAdministrador") {
                anclados.forEach((post) => {
                    this.sectionAnclados.innerHTML +=
                            `<article class="admin-post" post-id="${post.id}">
                        <p>by: <strong><span class="user-email">${post.usuarioAdministrador.correo}</span></strong></p>\n
                        <h2>${post.titulo}</h2>
                        <p>${post.contenido}</p>
                        <br><br>
                        <button id="eliminar-post-${post.id}">Eliminar</button>
                        <br><br>
                     </article>
                    `;
                });
            }
        })
    }

    renderComunes() {
        this.getPostsComunes().then((comunes) => {
            this.sectionComunes.innerHTML = '';

            if (this.userType == "ObjetosNegocio.UsuarioNormal") {
                console.log('UsuarioNormal');
                comunes.forEach((post) => {
                    this.sectionComunes.innerHTML += `
                    <article id="post-${post.id}" class="normal-post">
                        <p>by: <strong><span class="user-email">${post.usuario.correo}</span></strong></p>
                        <h2>${post.titulo}</h2>
                        <p>${post.contenido}</p>
                        <form id="comentario-form-post-${post.id}" class="comentario-form" post-id="${post.id}">
                            <textarea  name='comentario' required></textarea>
                            <button type="submit">Comenta</button>
                        </form>
                        <h5>Comentarios</h5>
                    </article>
                    `;
                });
            } else if (this.userType == "ObjetosNegocio.UsuarioAdministrador") {
                console.log('UsuarioAdmin');
                comunes.forEach((post) => {
                    this.sectionComunes.innerHTML += `
                    <article id="post-${post.id}" class="normal-post">
                        <p>by: <strong><span class="user-email">${post.usuario.correo}</span></strong></p>
                        <h2>${post.titulo}</h2>
                        <p>${post.contenido}</p>
                        <br><br>
                        <button id="eliminar-post-${post.id}">Eliminar</button>
                        <br><br>
                        <h5>Comentarios</h5>
                    </article>
                    `;
                });
            }
            return comunes;
        }).then((comunes) => {
            comunes.forEach((post) => {
                let postHtml = document.getElementById(`post-${post.id}`);
                this.getComentariosPostComunById(post.id).then((comentarios) => {
                    comentarios.forEach((comentario) => {
                        postHtml.innerHTML += `
                            <div>
                                <p>${comentario.usuarioNormal.correo}:  ${comentario.contenido}</p>
                                <p>${comentario.fechaHora}</p>
                                <br>
                            </div>
                        `;
                    });
                });
            });
        }).then((comunes) => {
            this.addEvtListeners();
        })
    }

    addEvtListeners() {
        this.getPostsComunes().then((comunes) => {
            if (this.userType == "ObjetosNegocio.UsuarioNormal") {
                comunes.forEach((post) => {
                    document.getElementById(`comentario-form-post-${post.id}`).addEventListener("submit", (evt) => {
                        evt.preventDefault();
                        let comentario = document.getElementById(`comentario-form-post-${post.id}`).elements[0].value;
                        if (!(comentario.length < 1)) {
                            let http = new XMLHttpRequest();
                            let url = `/blog/comentarios?comentario=${comentario}&postid=${post.id}&usertype=${this.userType}&usuarioemail=${this.usuarioEmail}`;
                            http.open("POST", url);
                            http.send();
                            this.renderAnclados();
                            this.renderComunes();
                            alert('Comentario Exitoso!');
                        } else
                            alert('Comentario Vacio');
                    });
                });
            }
            return comunes;
        }).then((comunes) => {
            comunes.forEach((post) => {
                if (this.userType == "ObjetosNegocio.UsuarioAdministrador") {
                    comunes.forEach((post) => {
                        document.getElementById(`eliminar-post-${post.id}`).addEventListener("click", (evt) => {

                            let http = new XMLHttpRequest();

                            let url = `/blog/posts?action=deletecomun&postid=${post.id}&usertype=${this.userType}&usuarioemail=${this.usuarioEmail}`;
                            http.open("POST", url);
                            http.send();
                            this.renderAnclados();
                            this.renderComunes();

                            let postArticle = document.getElementById(`eliminar-post-${post.id}`).parentElement;
                            this.sectionComunes.removeChild(postArticle);
                        });
                    });
                }
            });
        }).then(() => {
            this.getPostsAnclados().then((anclados) => {
                if (this.userType == "ObjetosNegocio.UsuarioAdministrador") {
                    anclados.forEach((post) => {
                        document.getElementById(`eliminar-post-${post.id}`).addEventListener("click", (evt) => {

                            let http = new XMLHttpRequest();

                            let url = `/blog/posts?action=deleteanclado&postid=${post.id}&usertype=${this.userType}&usuarioemail=${this.usuarioEmail}`;
                            http.open("POST", url);
                            http.send();
                            this.renderAnclados();
                            this.renderComunes();

                            let postArticle = document.getElementById(`eliminar-post-${post.id}`).parentNode;
                            this.sectionAnclados.removeChild(postArticle);
                        });
                    });
                }
            });
        });
    }

    getPostsAnclados() {
        return fetch('/blog/posts?action=anclados')
                .then((res) => res.json())
                .then((res) => res)
                .catch((err) => {
                    console.log(err);
                    alert('No se obtuvieron los posts :(');
                });
    }

    getPostsComunes() {
        return fetch('/blog/posts?action=comunes')
                .then((res) => res.json())
                .then((res) => res)
                .catch((err) => {
                    console.log(err);
                    alert('No se obtuvieron los posts :(');
                });
    }

    getComentariosPostComunById(id) {
        return fetch('/blog/comentarios?action=get&postid=' + id)
                .then((res) => res.json())
                .then((res) => res)
                .catch((err) => {
                    console.log(err);
                    alert('No se obtuvieron los comentarios :(');
                });
    }

    deletePostById(id) {
        let http = new XMLHttpRequest();
        let url = `/blog/posts?action=delete&postid=${id}`;
        http.open("POST", url);
        http.send();
        alert('Comentario Eliminado!');
    }

    printPostsComunes() {
        this.getPostsComunes()
                .then((res) => res.forEach((item) => console.log(item)));
    }

    printPostsAnclados() {
        this.getPostsAnclados()
                .then((res) => res.forEach((item) => console.log(item)));
    }
}

window.onload = () => new PostsManager();