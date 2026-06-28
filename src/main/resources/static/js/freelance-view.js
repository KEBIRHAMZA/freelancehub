// Affiche une liste de freelancers dans #result-container
function freelancersView(freelancers) {
    if (freelancers.length === 0) {
        document.getElementById('result-container').innerHTML =
            '<p>Aucun freelancer trouvé.</p>';
        return;
    }

    let html = `<h3>${freelancers.length} freelancer(s) trouvé(s)</h3>
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th><th>Nom</th><th>Email</th>
                    <th>Spécialité</th><th>Tarif/jour</th>
                </tr>
            </thead>
            <tbody>`;

    for (let f of freelancers) {
        html += `<tr>
            <td>${f.id}</td>
            <td>${f.name}</td>
            <td>${f.email}</td>
            <td>${f.specialty}</td>
            <td>${f.dailyRate} €</td>
        </tr>`;
    }

    html += '</tbody></table>';
    document.getElementById('result-container').innerHTML = html;
}

// Affiche une liste de missions
function missionsView(missions) {
    if (missions.length === 0) {
        document.getElementById('result-container').innerHTML =
            '<p>Aucune mission trouvée.</p>';
        return;
    }

    const statusClass = {
        'OPEN': 'badge-open',
        'IN_PROGRESS': 'badge-progress',
        'COMPLETED': 'badge-done',
        'CANCELLED': 'badge-done'
    };

    let html = `<h3>${missions.length} mission(s) trouvée(s)</h3>
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th><th>Titre</th><th>Client</th>
                    <th>Budget</th><th>Statut</th>
                </tr>
            </thead>
            <tbody>`;

    for (let m of missions) {
        const badge = statusClass[m.status] || '';
        html += `<tr>
            <td>${m.id}</td>
            <td>${m.title}</td>
            <td>${m.client}</td>
            <td>${m.budget} €</td>
            <td><span class="${badge}">${m.status}</span></td>
        </tr>`;
    }

    html += '</tbody></table>';
    document.getElementById('result-container').innerHTML = html;
}

// Affiche un message d'erreur
function errorView(message) {
    document.getElementById('result-container').innerHTML =
        `<p class="error">⚠ Erreur : ${message}</p>`;
}