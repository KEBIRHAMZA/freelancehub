const API_BASE = "http://localhost:8080/freelance/api";

// Utilitaire : affiche les infos de la réponse HTTP
function showHttpInfo(response) {
    document.getElementById('http-status').textContent = response.status;
    document.getElementById('http-status-text').textContent = response.statusText;
    document.getElementById('http-content-type').textContent =
        response.headers.get('content-type') || '—';
}

// GET /api/freelancers?name=xxx
function searchFreelancerByName() {
    const name = document.getElementById('freelancer-name-input').value.trim();
    if (!name) {
        errorView('Veuillez saisir un nom.');
        return;
    }

    fetch(`${API_BASE}/freelancers?name=${encodeURIComponent(name)}`)
        .then(response => {
            showHttpInfo(response);
            if (!response.ok) throw new Error("Erreur HTTP " + response.status);
            return response.json();
        })
        .then(freelancers => {
            freelancersView(freelancers);
        })
        .catch(err => errorView(err.message));
}

// GET /api/missions?status=xxx
function searchMissionsByStatus() {
    const status = document.getElementById('mission-status-select').value;
    if (!status) {
        errorView('Veuillez sélectionner un statut.');
        return;
    }

    fetch(`${API_BASE}/missions?status=${encodeURIComponent(status)}`)
        .then(response => {
            showHttpInfo(response);
            if (!response.ok) throw new Error("Erreur HTTP " + response.status);
            return response.json();
        })
        .then(missions => {
            missionsView(missions);
        })
        .catch(err => errorView(err.message));
}

// Touche Entrée sur le champ nom
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('freelancer-name-input')
        .addEventListener('keypress', e => {
            if (e.key === 'Enter') searchFreelancerByName();
        });
});