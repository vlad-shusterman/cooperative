import api from '../../../api/api'

export default {

    fetchTrusts() {
        return api().get('/vicarious/authority')
    }

}