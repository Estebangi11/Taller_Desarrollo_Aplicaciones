<%-- 
    Document   : index
    Created on : 2 nov. 2025, 9:00:31 p. m.
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Gestión de Gastos</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #2F3E50 0%, #1f2c3a 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            background: white;
            border-radius: 25px;
            border: 3px solid #4A90A4;
            padding: 50px 45px;
            max-width: 520px;
            width: 100%;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.3);
        }

        .icon-circle {
            width: 90px;
            height: 90px;
            background: #2F3E50;
            border-radius: 50%;
            margin: 0 auto 25px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .icon-circle svg {
            width: 45px;
            height: 45px;
            stroke: white;
            fill: none;
            stroke-width: 2;
        }

        h1 {
            color: #2F3E50;
            text-align: center;
            margin-bottom: 8px;
            font-size: 32px;
            font-weight: 600;
        }

        .subtitle {
            color: #95a5a6;
            text-align: center;
            margin-bottom: 35px;
            font-size: 15px;
        }

        .form-group {
            margin-bottom: 22px;
        }

        label {
            display: block;
            color: #2F3E50;
            font-weight: 600;
            margin-bottom: 10px;
            font-size: 15px;
        }

        input {
            width: 100%;
            padding: 14px 18px;
            border: none;
            background: #e8e8e8;
            border-radius: 8px;
            font-size: 15px;
            color: #2F3E50;
        }

        input:focus {
            outline: none;
            background: #dedede;
        }

        input::placeholder {
            color: #999;
        }

        .user-type-label {
            color: #2F3E50;
            font-weight: 600;
            margin-bottom: 15px;
            display: block;
            font-size: 15px;
        }

        .user-type-buttons {
            display: flex;
            gap: 12px;
            margin-bottom: 30px;
        }

        .user-type-btn {
            flex: 1;
            padding: 14px;
            border: none;
            background: #2F3E50;
            color: white;
            border-radius: 8px;
            cursor: pointer;
            font-weight: 600;
            font-size: 15px;
            transition: all 0.2s;
            opacity: 0.6;
        }

        .user-type-btn:hover {
            opacity: 0.8;
        }

        .user-type-btn.active {
            opacity: 1;
            box-shadow: 0 4px 12px rgba(47, 62, 80, 0.4);
        }

        .btn-login {
            width: 100%;
            padding: 16px;
            background: #2F3E50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 17px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-login:hover {
            background: #1f2c3a;
            box-shadow: 0 4px 12px rgba(47, 62, 80, 0.4);
        }

        .register-link {
            text-align: center;
            margin-top: 22px;
            color: #7f8c8d;
            font-size: 15px;
        }

        .register-link a {
            color: #4A90A4;
            text-decoration: none;
            font-weight: 600;
        }

        .register-link a:hover {
            text-decoration: underline;
        }

        .back-btn {
            width: 55px;
            height: 55px;
            background: #2F3E50;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            transition: all 0.2s;
            flex-shrink: 0;
        }

        .back-btn:hover {
            background: #1f2c3a;
            box-shadow: 0 4px 12px rgba(47, 62, 80, 0.4);
        }

        .back-btn svg {
            width: 28px;
            height: 28px;
            stroke: white;
            fill: none;
            stroke-width: 2.5;
        }

        .header-with-back {
            display: flex;
            align-items: center;
            margin-bottom: 30px;
            gap: 15px;
        }

        .header-info {
            flex: 1;
        }

        .user-badge {
            display: flex;
            align-items: center;
            gap: 12px;
            color: #2F3E50;
            font-weight: 600;
            font-size: 20px;
            margin-left: auto;
        }

        .user-badge svg {
            width: 30px;
            height: 30px;
            fill: #2F3E50;
        }

        .section-title {
            color: #2F3E50;
            font-size: 18px;
            margin-bottom: 15px;
            font-weight: 600;
        }

        .upload-area {
            border: none;
            border-radius: 8px;
            padding: 50px;
            text-align: center;
            background: #e8e8e8;
            margin-bottom: 30px;
            position: relative;
        }

        .upload-btn {
            background: #2F3E50;
            color: white;
            padding: 14px 35px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-weight: 600;
            font-size: 15px;
            transition: all 0.2s;
        }

        .upload-btn:hover {
            background: #1f2c3a;
            box-shadow: 0 4px 12px rgba(47, 62, 80, 0.4);
        }

        #fileInput {
            display: none;
        }

        .files-display {
            background: #2F3E50;
            border-radius: 8px;
            padding: 20px;
            min-height: 180px;
            color: white;
        }

        .file-item {
            background: rgba(255, 255, 255, 0.1);
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .file-item:last-child {
            margin-bottom: 0;
        }

        .file-info {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .file-icon {
            width: 24px;
            height: 24px;
            fill: white;
        }

        .file-name {
            font-size: 14px;
        }

        .delete-btn {
            background: rgba(231, 76, 60, 0.8);
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 13px;
            transition: all 0.2s;
        }

        .delete-btn:hover {
            background: rgba(231, 76, 60, 1);
        }

        .students-list {
            background: white;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            padding: 25px;
            min-height: 130px;
            margin-bottom: 25px;
        }

        .student-item {
            background: #f8f9fa;
            padding: 12px 15px;
            border-radius: 6px;
            margin-bottom: 8px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .student-item:last-child {
            margin-bottom: 0;
        }

        .student-name {
            color: #2F3E50;
            font-weight: 500;
        }

        .files-count {
            color: #7f8c8d;
            font-size: 14px;
        }

        .average-section {
            background: white;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            padding: 20px;
        }

        .average-header {
            display: flex;
            justify-content: space-between;
            padding: 10px 15px;
            background: #e8e8e8;
            border-radius: 6px;
            margin-bottom: 15px;
            font-weight: 600;
            color: #2F3E50;
        }

        .file-entry {
            display: flex;
            justify-content: space-between;
            padding: 12px 15px;
            background: #f8f9fa;
            border-radius: 6px;
            margin-bottom: 8px;
        }

        .file-entry:last-child {
            margin-bottom: 0;
        }

        .admin-btn {
            width: 100%;
            padding: 18px;
            background: #2F3E50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: 600;
            margin-bottom: 15px;
            cursor: pointer;
            transition: all 0.2s;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .admin-btn:hover {
            background: #1f2c3a;
            box-shadow: 0 4px 12px rgba(47, 62, 80, 0.4);
        }

        .admin-btn:last-child {
            margin-bottom: 0;
        }

        .hidden {
            display: none;
        }

        .empty-state {
            text-align: center;
            color: rgba(255, 255, 255, 0.6);
            padding: 20px;
            font-size: 14px;
        }

        #registerScreen h1 {
            font-size: 30px;
        }
    </style>
</head>

<body>
    <!-- Pantalla de Login -->
    <div id="loginScreen" class="container">
        <div class="icon-circle">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <rect x="2" y="5" width="20" height="14" rx="2" ry="2" />
                <line x1="2" y1="10" x2="22" y2="10" />
            </svg>
        </div>

        <h1>Iniciar Sesión</h1>
        <p class="subtitle">Ingresa tus credenciales para acceder</p>

        <form id="loginForm">
            <div class="form-group">
                <label>Usuario:</label>
                <input type="text" id="username" placeholder="Ingresa tu usuario" required>
            </div>

            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" id="password" placeholder="Ingresa tu contraseña" required>
            </div>

            <label class="user-type-label">Seleccione su tipo de Usuario:</label>
            <div class="user-type-buttons">
                <button type="button" class="user-type-btn" data-type="estudiante">Estudiante</button>
                <button type="button" class="user-type-btn" data-type="docente">Docente</button>
                <button type="button" class="user-type-btn" data-type="administrador">Administrador</button>
            </div>

            <button type="submit" class="btn-login">Iniciar Sesión</button>
        </form>

        <div class="register-link">
            ¿No tienes cuenta? <a href="#" id="registerLink">Regístrate</a>
        </div>
    </div>

    <!-- Pantalla de Registro -->
    <div id="registerScreen" class="container hidden">
        <div class="header-with-back">
            <div class="back-btn" onclick="showScreen('loginScreen')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <polyline points="15 18 9 12 15 6" />
                </svg>
            </div>
        </div>

        <div class="icon-circle">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <rect x="2" y="5" width="20" height="14" rx="2" ry="2" />
                <line x1="2" y1="10" x2="22" y2="10" />
            </svg>
        </div>

        <h1>Crear Cuenta</h1>
        <p class="subtitle">Crea una cuenta para comenzar a gestionar tus gastos</p>

        <form id="registerForm">
            <div class="form-group">
                <label>Usuario:</label>
                <input type="text" placeholder="Ingresa tu usuario" required>
            </div>

            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" placeholder="Ingresa tu contraseña:" required>
            </div>

            <button type="submit" class="btn-login">Registrarse</button>
        </form>
    </div>

    <!-- Pantalla Estudiante -->
    <div id="studentScreen" class="container hidden">
        <div class="header-with-back">
            <div class="back-btn" onclick="showScreen('loginScreen')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <polyline points="15 18 9 12 15 6" />
                </svg>
            </div>
            <div class="user-badge">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" />
                    <circle cx="12" cy="7" r="4" />
                </svg>
                Estudiante
            </div>
        </div>

        <div class="section-title">Subir un Archivo</div>
        <div class="upload-area">
            <input type="file" id="fileInput" accept=".pdf,.doc,.docx,.txt,.jpg,.png">
            <button class="upload-btn" onclick="document.getElementById('fileInput').click()">Seleccione
                Archivo</button>
        </div>

        <div class="section-title">Ver Archivos</div>
        <div class="files-display" id="filesDisplay">
            <div class="empty-state">No hay archivos subidos</div>
        </div>
    </div>

    <!-- Pantalla Docente -->
    <div id="teacherScreen" class="container hidden">
        <div class="header-with-back">
            <div class="back-btn" onclick="showScreen('loginScreen')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <polyline points="15 18 9 12 15 6" />
                </svg>
            </div>
            <div class="user-badge">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2" />
                    <circle cx="9" cy="7" r="4" />
                    <path d="M23 21v-2a4 4 0 0 0-3-3.87" />
                    <path d="M16 3.13a4 4 0 0 1 0 7.75" />
                </svg>
                Docente
            </div>
        </div>

        <div class="section-title">Estudiantes:</div>
        <div class="students-list" id="studentsList"></div>

        <div class="section-title">Promedio:</div>
        <div class="average-section">
            <div class="average-header">
                <span>Archivo</span>
                <span>Estudiante</span>
            </div>
            <div id="filesListTeacher"></div>
        </div>
    </div>

    <!-- Pantalla Administrador -->
    <div id="adminScreen" class="container hidden">
        <div class="header-with-back">
            <div class="back-btn" onclick="showScreen('loginScreen')">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <polyline points="15 18 9 12 15 6" />
                </svg>
            </div>
            <div class="user-badge">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" />
                    <circle cx="12" cy="7" r="4" />
                </svg>
                Ver Gastos
            </div>
        </div>

        <div class="section-title">Historial de Gastos:</div>

        <button class="admin-btn">VER ESTADÍSTICAS</button>
        <button class="admin-btn">GESTIONAR USUARIOS</button>
        <button class="admin-btn">GESTIONAR ARCHIVOS</button>
        <button class="admin-btn">VER REPORTES</button>
        <button class="admin-btn">CONFIGURAR SISTEMA</button>
    </div>

    <script>
        let selectedUserType = null;
        let currentUsername = '';
        let uploadedFiles = [];

        // Manejo de selección de tipo de usuario
        document.querySelectorAll('.user-type-btn').forEach(btn => {
            btn.addEventListener('click', function () {
                document.querySelectorAll('.user-type-btn').forEach(b => b.classList.remove('active'));
                this.classList.add('active');
                selectedUserType = this.dataset.type;
            });
        });

        // Función para mostrar pantallas
        function showScreen(screenId) {
            document.querySelectorAll('.container').forEach(screen => {
                screen.classList.add('hidden');
            });
            document.getElementById(screenId).classList.remove('hidden');

            if (screenId === 'teacherScreen') {
                updateTeacherView();
            }
        }

        // Manejo del formulario de login
        document.getElementById('loginForm').addEventListener('submit', function (e) {
            e.preventDefault();

            if (!selectedUserType) {
                alert('Por favor selecciona un tipo de usuario');
                return;
            }

            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;

            if (username && password) {
                currentUsername = username;

                switch (selectedUserType) {
                    case 'estudiante':
                        showScreen('studentScreen');
                        break;
                    case 'docente':
                        showScreen('teacherScreen');
                        break;
                    case 'administrador':
                        showScreen('adminScreen');
                        break;
                }
            }
        });

        // Manejo de subida de archivos
        document.getElementById('fileInput').addEventListener('change', function (e) {
            const file = e.target.files[0];
            if (file) {
                const fileData = {
                    name: file.name,
                    size: (file.size / 1024).toFixed(2) + ' KB',
                    student: currentUsername,
                    date: new Date().toLocaleDateString()
                };

                uploadedFiles.push(fileData);
                displayFiles();

                this.value = '';
            }
        });

        // Mostrar archivos en la vista de estudiante
        function displayFiles() {
            const filesDisplay = document.getElementById('filesDisplay');

            if (uploadedFiles.length === 0) {
                filesDisplay.innerHTML = '<div class="empty-state">No hay archivos subidos</div>';
                return;
            }

            filesDisplay.innerHTML = uploadedFiles.map((file, index) => `
                <div class="file-item">
                    <div class="file-info">
                        <svg class="file-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor">
                            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"/>
                            <polyline points="14 2 14 8 20 8"/>
                        </svg>
                        <div>
                            <div class="file-name">${file.name}</div>
                            <div style="font-size: 12px; opacity: 0.7;">${file.size}</div>
                        </div>
                    </div>
                    <button class="delete-btn" onclick="deleteFile(${index})">Eliminar</button>
                </div>
            `).join('');
        }

        // Eliminar archivo
        function deleteFile(index) {
            uploadedFiles.splice(index, 1);
            displayFiles();
        }

        // Actualizar vista del docente
        function updateTeacherView() {
            const studentsList = document.getElementById('studentsList');
            const filesListTeacher = document.getElementById('filesListTeacher');

            const students = {};
            uploadedFiles.forEach(file => {
                if (!students[file.student]) {
                    students[file.student] = [];
                }
                students[file.student].push(file);
            });

            if (Object.keys(students).length === 0) {
                studentsList.innerHTML = '<div style="color: #95a5a6; text-align: center;">No hay estudiantes con archivos</div>';
                filesListTeacher.innerHTML = '<div style="color: #95a5a6; text-align: center; padding: 15px;">No hay archivos disponibles</div>';
                return;
            }

            studentsList.innerHTML = Object.keys(students).map(studentName => `
                <div class="student-item">
                    <span class="student-name">${studentName}</span>
                    <span class="files-count">${students[studentName].length} archivo(s)</span>
                </div>
            `).join('');

            filesListTeacher.innerHTML = uploadedFiles.map(file => `
                <div class="file-entry">
                    <span>${file.name}</span>
                    <span>${file.student}</span>
                </div>
            `).join('');
        }

        // Enlace de registro
        document.getElementById('registerLink').addEventListener('click', function (e) {
            e.preventDefault();
            showScreen('registerScreen');
        });

        // Manejo del formulario de registro
        document.getElementById('registerForm').addEventListener('submit', function (e) {
            e.preventDefault();
            alert('Cuenta creada exitosamente');
            showScreen('loginScreen');
        });
    </script>
</body>

</html>